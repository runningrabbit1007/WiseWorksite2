/*
 * Copyright (c) 2013. wyouflf (wyouflf@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lidroid.xutils.bitmap.download;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.util.IOUtils;
import com.lidroid.xutils.util.OtherUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;

public class DefaultDownloader extends Downloader {

	/**
	 * Download bitmap to outputStream by uri.
	 * 
	 * @param uri
	 *            file path, assets path(assets/xxx) or http url.
	 * @param outputStream
	 * @param task
	 * @return The expiry time stamp or -1 if failed to download.
	 */
	@Override
	public long downloadToStream(String uri, OutputStream outputStream,
			final BitmapUtils.BitmapLoadTask<?> task) {

		if (task == null || task.isCancelled()
				|| task.getTargetContainer() == null)
			return -1;

		URLConnection urlConnection = null;
		BufferedInputStream bis = null;

		OtherUtils.trustAllHttpsURLConnection();

		long result = -1;
		long fileLen = 0;
		long currCount = 0;
		try {
			if (uri.startsWith("/")) {
				FileInputStream fileInputStream = new FileInputStream(uri);
				fileLen = fileInputStream.available();
				bis = new BufferedInputStream(fileInputStream);
				result = System.currentTimeMillis() + this.getDefaultExpiry();
			} else if (uri.startsWith("assets/")) {
				InputStream inputStream = this.getContext().getAssets()
						.open(uri.substring(7, uri.length()));
				fileLen = inputStream.available();
				bis = new BufferedInputStream(inputStream);
				result = Long.MAX_VALUE;
			} else if (isNumeric(uri)) {
				// 加载R下面的图片
				int drawableId = Integer.parseInt(uri); // 还原原始的 id
				InputStream inputStream = this.getContext().getResources()
						.openRawResource(drawableId);
				fileLen = inputStream.available();// 抄上面的
				bis = new BufferedInputStream(inputStream); // 抄上面的
				result = Long.MAX_VALUE;// 抄上面的,先这么写,以后讨论
			} else {
				final URL url = new URL(uri);
				urlConnection = url.openConnection();
				urlConnection
						.setConnectTimeout(this.getDefaultConnectTimeout());
				urlConnection.setReadTimeout(this.getDefaultReadTimeout());
				bis = new BufferedInputStream(urlConnection.getInputStream());
				result = urlConnection.getExpiration();
				result = result < System.currentTimeMillis() ? System
						.currentTimeMillis() + this.getDefaultExpiry() : result;
				fileLen = urlConnection.getContentLength();
			}

			if (task.isCancelled() || task.getTargetContainer() == null)
				return -1;

			byte[] buffer = new byte[4096];
			int len = 0;
			BufferedOutputStream out = new BufferedOutputStream(outputStream);
			while ((len = bis.read(buffer)) != -1) {
				out.write(buffer, 0, len);
				currCount += len;
				if (task.isCancelled() || task.getTargetContainer() == null)
					return -1;
				task.updateProgress(fileLen, currCount);
			}
			out.flush();
		} catch (Throwable e) {
			result = -1;
		} finally {
			IOUtils.closeQuietly(bis);
		}
		return result;
	}

	// 1、正则表达式
	private boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
}

package com.common.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.common.utils.GeneralUtil;
import com.common.utils.ToastUtil;


/**
 * 
 * ============================================================
 * 
 * project name :DiDi professor
 * 
 * copyright ZENG HUI (c) 2014
 * 
 * author : HUI
 * 
 * version : 1.0
 * 
 * date created : On December 24, 2014 9:37:31
 * 
 * description : General input box control, the left is the written word is the
 * input box on the right
 * 
 * revision history :
 * 
 * ============================================================
 * 
 */
@SuppressLint({ "Recycle", "InlinedApi", "DefaultLocale" })
public class GeneralEditText extends RelativeLayout {
	private Context mContext;
	/** right edit text **/
	private EditText mEditText;
	/** left text view **/
	private TextView mName;
	/** edit text background **/
	private int mBackgroud;
	/** get right edit text content **/
	private CharSequence mNameStr;
	/** get right edit text hint **/
	private String mhintStr;
	/** Around the edit text padding value **/
	private int mPaddingPx;
	/** The types of input fields **/
	private String type;
	/** Enter the default edit text **/
	private String mDefalutText;

	private int mNameBackground;

	public GeneralEditText(Context context) {
		super(context);
	}

	public GeneralEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
		init();
		// typed array
		TypedArray array = context.obtainStyledAttributes(attrs,
				R.styleable.GeneralEditText);

		// get left name (string)
		mNameStr = array.getText(R.styleable.GeneralEditText_text);
		mNameBackground = array.getResourceId(R.styleable.GeneralEditText_text, 0);

		if (mNameBackground != 0) {
			mName.setBackgroundResource(mNameBackground);
		} else if (!TextUtils.isEmpty(mNameStr)) {
			mName.setText(mNameStr);
		} else {
			// If the text is empty we will hide the input box and its margin
			// value to 0
			mName.setVisibility(View.GONE);
			LayoutParams lp = new LayoutParams(
					LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT); // , 1是可选写的
			lp.setMargins(0, 0, 0, 0);
			mEditText.setLayoutParams(lp);
		}
		// get edit text background
		mBackgroud = array.getResourceId(R.styleable.GeneralEditText_background, 0);
		mEditText.setBackgroundResource(mBackgroud);

		// set edit text input type (password or number)
		type = array.getString(R.styleable.GeneralEditText_inputType);
		if ("number".equals(type)) {
			mEditText.setInputType(TypedValue.TYPE_STRING);
//			mEditText.setKeyListener(new DigitsKeyListener(false, false));
			mEditText.setKeyListener(new NumberKeyListener() {  
			    public int getInputType() {  
			        return InputType.TYPE_CLASS_NUMBER;  
			    }  
			  
			    protected char[] getAcceptedChars() {  
			  
			        char[] numbers = new char[] { '.', '0', '1', '2', '3', '4', '5','6','7','8','9'};  
			        return numbers;  
			    }  
			});  

		}

		if ("phone".equals(type)) {
			mEditText.setInputType(TypedValue.TYPE_STRING);
			this.addTextChangedListener(phoneNumbersAddSpacesTextWatcher);
		}

		if ("password".equals(type)) {
			mEditText.setInputType(InputType.TYPE_CLASS_TEXT
					| InputType.TYPE_TEXT_VARIATION_PASSWORD);
		}

		// set padding value
		mPaddingPx = (int) array.getDimension(R.styleable.GeneralEditText_padding, 5);
		mEditText.setPadding(mPaddingPx, mPaddingPx, mPaddingPx, mPaddingPx);

		// get edit text hint content
		mhintStr = (String) array.getText(R.styleable.GeneralEditText_hint);
		if (!TextUtils.isEmpty(mhintStr)) {
			mEditText.setHint(mhintStr);
		}

		// get edit text lines
		int lines = array.getInteger(R.styleable.GeneralEditText_lines, 0);
		if (lines != 0) {
			mEditText.setMinLines(lines);
			// mEditText.setLines(lines); 因为这里设置的是显示的时候lines，所以无论多少字也只能显示这么高。
			mEditText.setGravity(Gravity.TOP);
		}

		int maxLength = array.getInteger(R.styleable.GeneralEditText_maxLength, 0);
		if (maxLength != 0) {
			mEditText
					.setFilters(new InputFilter[] { new InputFilter.LengthFilter(
							maxLength) });
			mEditText.setMaxEms(maxLength);
		}

		// what is get input box default input
		mDefalutText = attrs.getAttributeValue(null, "defaultContent");
		if (!TextUtils.isEmpty(mDefalutText)) {
			mEditText.setText(mDefalutText);
		}
		array.recycle();
	}

	/**
	 * initialization
	 */
	private void init() {
		LayoutInflater inflater = LayoutInflater.from(mContext);
		View view = inflater.inflate(R.layout.ui_general_edittext, this);
		mEditText = (EditText) view.findViewById(R.id.edittext_content);
		mName = (TextView) view.findViewById(R.id.edittext_name);
	}

	/**
	 * @description edit text whether empty
	 * @return
	 */
	public boolean isEmpty() {
		return TextUtils.isEmpty(getTextByTrim());
	}

	/**
	 * @description Get the content of the edit text (remove Spaces)
	 * @return
	 */
	public String getTextByTrim() {
		return removeAllSpace(mEditText.getText().toString().trim());
	}

	/**
	 * @description Get the content of the edit text (not remove Spaces)
	 * @return
	 */
	public String getTextNoTrim() {
		return mEditText.getText().toString();
	}

	public void setOnTouchListenerOverride(OnTouchListener touchListener) {
		mEditText.setOnTouchListener(touchListener);
	}

	/**
	 * The animation of the edit text by shake
	 */
	public void startAnimationOfshake() {
		Animation shake = AnimationUtils
				.loadAnimation(mContext, R.anim.shake_x);
		mEditText.startAnimation(shake);
		mEditText.requestFocus();
	}

	/**
	 * Set the edit text animation
	 */
	public void startAnimation(Animation shake) {
		mEditText.startAnimation(shake);
	}

	/**
	 * set edit text content
	 */
	public void setText(CharSequence text) {
		mEditText.setText(text);
	}

	/**
	 * set edit text is enabled
	 */
	public void setEnabled(boolean avliable) {
		mEditText.setEnabled(avliable);
	}

	/**
	 * Check for null with printing and the focal point of the request
	 */
	public boolean checkIsEmpty(String string) {
		if (isEmpty()) {
			startAnimationOfshake();
			ToastUtil.showToast(mContext,string);
			return true;
		}
		return false;
	}

	/**
	 * Check for null with printing and the focal point of the request
	 */
	public boolean checkIsEmpty() {
		if (isEmpty()) {
			startAnimationOfshake();
			// 默认显示hint提示文字
			ToastUtil.showToast( mContext,mEditText.getHint());
			return true;
		}
		return false;
	}

	/**
	 * 清除掉输入框的文字
	 */
	public void clear() {
		mEditText.setText("");
	}

	/**
	 * 检测其是不是一个邮箱
	 * 
	 * @return true 是一个邮箱,false 不是一个邮箱
	 */
	public boolean checkIsEmail() {
		// 先判断是否为空
		if (isEmpty()) {
			startAnimationOfshake();
			ToastUtil.showToast( mContext,"请输入您的邮箱");
			return false;
		}
		boolean isEmail = GeneralUtil.judgeEmailQual(getTextByTrim());
		if (!isEmail) {
			startAnimationOfshake();
			ToastUtil.showToast( mContext,"请输入正确的邮箱格式");
		}
		return isEmail;
	}

	/**
	 * 检测其是否是一个电话号码或是邮箱
	 */
	public boolean checkIsPhoneAndEmail(String msg) {
		boolean isPhone = GeneralUtil.judgePhoneQual(getTextByTrim());
		boolean isEmail = GeneralUtil.judgeEmailQual(getTextByTrim());
		if (!isPhone && !isEmail) {
			startAnimationOfshake();
			ToastUtil.showToast(mContext,msg);
		}
		return !(!isPhone && !isEmail);
	}

	/**
	 * 检测其是否是一个电话号码
	 * 
	 * @return true 是电话号码,false 不是电话号码
	 */
	public boolean checkIsPhone() {
		// 先判断是否为空
		if (isEmpty()) {
			startAnimationOfshake();
			ToastUtil.showToast(mContext,"请输入您的手机号码");
			return false;
		}
		boolean isPhone = GeneralUtil.judgePhoneQual(getTextByTrim());
		if (!isPhone) {
			startAnimationOfshake();
			ToastUtil.showToast(mContext,"请输入正确的手机号码");
		}
		return isPhone;
	}

	public String removeAllSpace(String str) {
		String tmpstr = str.replace(" ", "");
		return tmpstr;
	}

	/**
	 * 检测其是否是一个年龄
	 */
	public boolean checkIsAge() {
		// 先判断是否为空
		if (isEmpty()) {
			startAnimationOfshake();
			ToastUtil.showToast(mContext,"请输入您的工龄");
			return false;
		}
		// try catch ..
		int age = Integer.parseInt(getTextByTrim());
		if (age <= 0 || age > 100) {
			startAnimationOfshake();
			ToastUtil.showToast(mContext,"请输入正确的工龄范围");
			return false;
		}
		return true;
	}

	/**
	 * 检测其是否是一个性别
	 * 
	 * @return true 是电话号码,false 不是电话号码
	 */
	public boolean checkIsSex() {
		// 先判断是否为空
		if (isEmpty()) {
			startAnimationOfshake();
			ToastUtil.showToast(mContext,"请输入您的性别");
			return false;
		}
		boolean isSex = GeneralUtil.JudgeSexQual(getTextByTrim());
		if (!isSex) {
			startAnimationOfshake();
			ToastUtil.showToast( mContext,"请输入正确的性别");
			return false;
		}
		return true;
	}

	/**
	 * 检测其是否是身份证号
	 * 
	 * @return true 是身份证号,false 不是身份证号
	 */
	public boolean checkIsIDCrad() {
		// 先判断是否为空
		if (isEmpty()) {
			startAnimationOfshake();
			ToastUtil.showToast(mContext,mEditText.getHint());
			return false;
		}
		String info = GeneralUtil.IDCardValidate(getTextByTrim().toLowerCase());
		if (!TextUtils.isEmpty(info)) {
			startAnimationOfshake();
			ToastUtil.showToast( mContext,info);
			return false;
		}
		return true;
	}

	/**
	 * 检测长度是否符合
	 * 
	 * @param length
	 *            检测的长度
	 * @return true 符合 , false 不符合
	 */
	public boolean checkLengthEnough(String str, int length) {
		// 先判断是否为空
		if (isEmpty()) {
			startAnimationOfshake();
			ToastUtil.showToast(mContext,str);
			return false;
		}
		int mLength = getTextByTrim().length();
		if (mLength < length) {
			ToastUtil.showToast(mContext,str);
			startAnimationOfshake();
		}
		return mLength >= length;
	}

	/**
	 * 输入框文本和密码切换
	 */
	public void hiddenEditText(boolean isShow) {
		if (isShow) {
			// 设置EditText文本为可见的
			mEditText.setTransformationMethod(HideReturnsTransformationMethod
					.getInstance());
		} else {
			// 设置EditText文本为隐藏的
			mEditText.setTransformationMethod(PasswordTransformationMethod
					.getInstance());
		}

		// the cursor to the end
		GeneralUtil.cursorToEnd(mEditText);
	}

	/**
	 * 添加输入框改变的监听
	 */
	public void addTextChangedListener(TextWatcher watcher) {
		mEditText.addTextChangedListener(watcher);
	}

	/**
	 * 电话号码自动加空格
	 */
	public void phoneNumbersAddSpaces() {
		mEditText.addTextChangedListener(phoneNumbersAddSpacesTextWatcher);
	}

	/**
	 * 自动添加空格的TextWatcher
	 */
	private TextWatcher phoneNumbersAddSpacesTextWatcher = new TextWatcher() {
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			if (s == null || s.length() == 0)
				return;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				if (i != 3 && i != 8 && s.charAt(i) == ' ') {
					continue;
				} else {
					sb.append(s.charAt(i));
					if ((sb.length() == 4 || sb.length() == 9)
							&& sb.charAt(sb.length() - 1) != ' ') {
						sb.insert(sb.length() - 1, ' ');
					}
				}
			}
			if (!sb.toString().equals(s.toString())) {
				int index = start + 1;
				if (sb.charAt(start) == ' ') {
					if (before == 0) {
						index++;
					} else {
						index--;
					}
				} else {
					if (before == 1) {
						index--;
					}
				}
				mEditText.setText(sb.toString());
				mEditText.setSelection(index);
			}

		}

		@Override
		public void afterTextChanged(Editable s) {

		}
	};

	/**
	 * 将字符串转为数字
	 * 
	 * @return
	 */
	public int getNumberByTrim() {
		if (TextUtils.isEmpty(mEditText.getText().toString())) {
			return 0;
		} else {
			return Integer.parseInt(mEditText.getText().toString().trim());
		}
	}

	/**
	 * 设置显示内容为数字和文本
	 */
	public void setIsShowNumberText() {
		mEditText.setInputType(InputType.TYPE_CLASS_TEXT
				| InputType.TYPE_TEXT_VARIATION_PASSWORD);
		hiddenEditText(true);
	}

	/**
	 * 得到文本框的内容长度是否超过length
	 * 
	 * @return
	 */
	public boolean lengthLargerThan(int length) {
		if (mEditText.getText().toString().trim().length() > length) {
			startAnimationOfshake();
			return true;
		}
		return false;
	}

	public void setHint(CharSequence hint) {
		mEditText.setHint(hint);
	}

	public void setInputType(int type) {
		mEditText.setInputType(type);
	}

	/**
	 * Get edit text of current view
	 */
	public EditText getEditText() {
		return mEditText;
	}

	public void setEditTextGravity(int gravity) {
		mEditText.setGravity(gravity);
	}

	public void setMaxLines(int maxlines) {
		mEditText.setMaxLines(maxlines);
	}
}
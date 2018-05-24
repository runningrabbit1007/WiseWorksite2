/*


import com.common.utils.LogUtils;
import com.sx.common_base.modle.ApiEntity;
import com.sx.common_base.util.ApiMaster;

import java.util.ArrayList;

*/
/**
 * Author : Jack
 * Email  : jackzhonglyy@outlook.com
 * Date   : 2016/9/28
 * Desc   : 数据库操作工具类
 * 表描述：
 * 1.GroupInfo 群信息表格，需要保存当前登录用户信息（userMemberId），考虑用户切换数据的使用场景
 * 2.User 用户信息表格，使用环信用户id作为主键，以此来保证该表中只有一份用户信息
 * 3.GroupMember 群成员关系表格，该表格中仅保存群的身份信息（imGroupId、friendGroupId）和该群中所有用户的身份信息（imUserId），一对多的映射
 * 4.UserRelation 好友关系表格，该表格中仅保存当前登录用户的身份信息（userMemberId）和该用户的好友信息的身份信息（imUserId、friendId），一对多的映射
 * 5.InviteRecord 好友邀请记录表格，需要保存当前登录用户的信息（userMemberId），考虑用户切换数据的使用场景
 * 6.ContactLocal 联系人表格，需要保存当前登录用户信息（userMemberId），考虑用户切换数据的使用场景
 * 7.SocialSearchHistory 搜索数据表格，需要保存当前登录用户信息（userMemberId），考虑用户切换数据的使用场景
 * 8.ChannelData 频道页Bean
 * 9.ChannelContent 频道页内容
 * 10.ActivityNoticeEntity 活动通知
 * 11.NoticeEntity  商圈通知、店铺通知、系统通知
 *//*


public class QueryHelper {


    */
/**
     * 存储或更新某个缓存内容
     * 1. 检查MaxCount，如果超过maxcount，则删除最早的数据
     *
     * @param cacheEntity
     *//*

    public static void saveCache(CacheEntity cacheEntity) {
        ApiEntity api = ApiMaster.findApiByUrl(cacheEntity.getApi());
        if (api != null && Integer.parseInt(api.expires) > 0) {//如果apientity不为null，而且有缓存时间，则去数据库中进行操作，去处理是否超过了maxcount，然后在合适的时机存储cacheEntity
            int size = 0;
            List<CacheEntity> list = new ArrayList<>();
            try {
                //查询数据库中该接口下已缓存的所有数据。
                list = getDaoSession().getCacheEntityDao().queryBuilder().where(CacheEntityDao.Properties.Api.eq(cacheEntity.getApi())).orderAsc(CacheEntityDao.Properties.EndTime).list();
                size = list.size();
            } catch (Exception e) {
                getDaoSession().getCacheEntityDao().insertOrReplace(cacheEntity);
            }
            if (api.maxCount <= size && api.maxCount > 0) {//如果缓存超过最大存储数据，删除最早的数据
                int endIndex = (api.maxCount + 1) - size;
                for (int i = 0; i < endIndex; i++) {
                    getDaoSession().getCacheEntityDao().deleteByKey(list.get(endIndex).getId());
                }
            }

            //最后插入或者更新数据
            getDaoSession().getCacheEntityDao().insertOrReplace(cacheEntity);
        }
    }


    */
/**
     * 检查一个key是否有缓存过期
     *
     * @param cacheKey 缓存KEY
     * @return true 表示缓存为NULL或者缓存已经过期了
     * false表示有缓存，并且没有过期
     *//*

    public static boolean checkCacheDue(String cacheKey) {

        CacheEntity cacheEntity = getCacheEntity(cacheKey);

        if (cacheEntity != null) {
            LogUtils.d("System.currentTimeMillis() == " + System.currentTimeMillis() + "getEndTime == " +cacheEntity.getEndTime());
            if (System.currentTimeMillis() > cacheEntity.getEndTime()) {//如果缓存过期之后，去判断他的缓存时间作用域有多大
                if (cacheEntity.getScope() == ConstantValue.YES_INT_TAG) {//如果是全组范围，则删除全组缓存
                    List<CacheEntity> list = getDaoSession().getCacheEntityDao().queryBuilder().where(CacheEntityDao.Properties.Api.eq(cacheEntity.getApi())).list();
                    getDaoSession().getCacheEntityDao().deleteInTx(list);
                } else {//删除这一条缓存
                    getDaoSession().getCacheEntityDao().delete(cacheEntity);
                }
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    */
/**
     * 查找某一条缓存
     *
     * @param cacheKey
     * @return
     *//*

    public static CacheEntity getCacheEntity(String cacheKey) {
        CacheEntity cacheEntity = null;
        try {
            cacheEntity = getDaoSession().getCacheEntityDao().queryBuilder()
                    .where(CacheEntityDao.Properties.CacheKey.eq(cacheKey)).list().get(0);
        } catch (Exception e) {
        }

        return cacheEntity;

    }

    public static DaoSession getDaoSession() {
        return ConfigureApplication.getInstance().getDaoSession();
    }






}

*/

package com.nasduck.duckupdate.base;

import com.nasduck.duckupdate2.bean.ResponseBean;

/**
 * 检查更新的回调监听。
 *
 * <p>设置方式：通过{@link UpdateConfig#setCheckCallback(CheckCallback)}或者{@link UpdateBuilder#setCheckCallback(CheckCallback)}进行设置。
 *
 * @author haoge
 */
public interface RequestCallBack {

    /**
     * 当使用{@link UpdateBuilder#update()}进行启动更新任务时。通知到此回调中。
     *
     * <p>回调线程：与更新任务启动线程一致
     */
    void onUpdateStart();

    /**
     * 当通过{@link Requester}进行更新api检查成功时。即检查到有新版本需要更新时，通知到此回调中：
     *
     * <p>回调线程：UI
     * @param responseBean 更新数据实体类
     */
    void onHasUpdate(ResponseBean responseBean);

    /**
     * 当检查到无更新时。通知到此：
     *
     * <p>回调线程：UI
     */
    void onNoUpdate();

    /**
     * 当进行更新检查失败，内部发生异常时。通知到此
     *
     * <p>回调线程：UI
     * @param t 发生异常实例
     */
    void onCheckError(Throwable t);

    /**
     * 当用户主动取消时触发到此回调中。主动取消的触发入口在{@link CheckNotifier#sendUserCancel()}和{@link InstallNotifier#sendUserCancel()}
     *
     * <p>回调线程：UI
     */
    void onUserCancel();

    /**
     * 当用户点击忽略此版本更新时触发到此回调中。触发入口在{@link CheckNotifier#sendUserIgnore()}和{@link InstallNotifier#sendCheckIgnore()}
     *
     * <p>回调线程：UI
     * @param update Update entity
     */
    void onCheckIgnore(Update update);
}

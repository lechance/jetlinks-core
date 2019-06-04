package org.jetlinks.core.message.interceptor;

import org.jetlinks.core.device.DeviceOperation;
import org.jetlinks.core.message.DeviceMessage;
import org.jetlinks.core.message.DeviceMessageReply;

import java.util.concurrent.CompletionStage;

/**
 * 设备消息发送拦截器,用于在消息发送端拦截处理消息.
 * 可用于在一些自定义回复逻辑的场景
 *
 * @see org.jetlinks.core.device.DeviceMessageSender
 * @since 1.0.0
 */
public interface DeviceMessageSenderInterceptor {

    /**
     * 在消息发送前触发,如果设备未在线,将不会触发此方法. 执行此方法后将使用返回值{@link DeviceMessage}进行发送到设备.
     *
     * @param device  设备操作接口
     * @param message 消息对象
     * @return 新的消息
     */
    DeviceMessage preSend(DeviceOperation device, DeviceMessage message);

    /**
     * 在消息收到回复后触发,并返回新的值.
     *
     * @param device  设备操作接口
     * @param message 源消息
     * @param reply   回复的消息
     * @param <R>     回复的消息类型
     * @return 新的回复结果
     */
    <R extends DeviceMessageReply> CompletionStage<R> afterReply(DeviceOperation device, DeviceMessage message, R reply);

}
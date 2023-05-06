package com.simple.keen.kafka.producer;

import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

public interface Producer {

    SendResult syncSend(String topic, Object data);

    ListenableFuture<SendResult<Object, Object>> asyncSend(String topic, Object data);

}

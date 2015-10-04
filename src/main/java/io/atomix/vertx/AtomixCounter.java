/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package io.atomix.vertx;

import io.atomix.atomic.DistributedAtomicLong;
import io.atomix.catalyst.util.Assert;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.shareddata.Counter;

/**
 * Atomix counter.
 *
 * @author <a href="http://github.com/kuujo>Jordan Halterman</a>
 */
public class AtomixCounter implements Counter {
  private final DistributedAtomicLong counter;

  public AtomixCounter(DistributedAtomicLong counter) {
    this.counter = Assert.notNull(counter, "counter");
  }

  @Override
  public void get(Handler<AsyncResult<Long>> handler) {
    counter.get().whenComplete(VertxFutures.resultHandler(handler));
  }

  @Override
  public void incrementAndGet(Handler<AsyncResult<Long>> handler) {
    counter.incrementAndGet().whenComplete(VertxFutures.resultHandler(handler));
  }

  @Override
  public void getAndIncrement(Handler<AsyncResult<Long>> handler) {
    counter.getAndIncrement().whenComplete(VertxFutures.resultHandler(handler));
  }

  @Override
  public void decrementAndGet(Handler<AsyncResult<Long>> handler) {
    counter.decrementAndGet().whenComplete(VertxFutures.resultHandler(handler));
  }

  @Override
  public void addAndGet(long delta, Handler<AsyncResult<Long>> handler) {
    counter.addAndGet(delta).whenComplete(VertxFutures.resultHandler(handler));
  }

  @Override
  public void getAndAdd(long delta, Handler<AsyncResult<Long>> handler) {
    counter.getAndAdd(delta).whenComplete(VertxFutures.resultHandler(handler));
  }

  @Override
  public void compareAndSet(long expect, long update, Handler<AsyncResult<Boolean>> handler) {
    counter.compareAndSet(expect, update).whenComplete(VertxFutures.resultHandler(handler));
  }

}



#### 程序清单 14-1 可阻塞的状态依赖操作的结构

```
acquire lock on object state
while (precondition does not hold) {
    release lock
    wait until precondition might hold
    optionally fail if interrupted or timeout expires
    reacquire lock
}
perform action
    release lock
```








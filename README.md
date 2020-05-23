# AQS_DEMO
## 自定义同步组件 AbstractQueuedSynchronizer

### Question
设置一个同步工具，该工具在同一时刻，只允许至多两个线程同时访问，超过两个线程访问将被阻塞。

由于至多两个线程同时访问，所以采用共享式同步状态获取,重写tryAcquiredShared()和tryReleaseShared等方法获得和释放同步状态来实现。

- JVM的参数类型
- 运行时JVM参数查看
- jstat查看虚拟机统计信息
- jmap+mat实战内存溢出
- jstack实战死循环监控


### JVM参数
#### 标准参数
```
- help
- server
 -client
 -version -showversion
 -cp -classpath
```

#### x参数
```
- Xint:解释执行
- Xcomp:本地编译执行
- Xmixed:混合模式，JVM自己决定
```

#### xx参数
- boolean类型
- 非boolean类型
- Xms -Xmx



##### boolean类型
```
-XX:[+-]<name> 启动或禁用name属性
```
例如
```
-XX:+UseConcMarkSweepGC 垃圾回收GC
-XX:+UseG1GC
```
##### 非boolean类型
```
-XX:<name>=<value>  表示name的属性为value
```
比如
```
-XX:MaxGCPauseMillis=500 GC最大停顿时间500ms
-XX:GCTimeRatio=19
```
##### Xms -xmx
- Xmx 等价于 -XX:MaxHeapSize 最大堆大小
- Xms 等价于 -XX:InitialHeapSize 初始化堆大小 
- Xss -XX:ThreadStackSize 线程堆栈大小

- XX:+PrintFlagsInitial 查看初始值
- XX:+PrintFlagsFinal 查看最终值
- XX:+UnlockExperimentalVMOptions解锁实验参数
- XX:+UnlockDiagnosticVMOptiongs 解锁诊断参数
- XX:+PrintCommandLineFlags 打印命令行参数

### jps





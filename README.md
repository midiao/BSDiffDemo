## Android应用增量更新
### 背景
自从 Android 4.1 开始，Google引入了应用程序的增量更新。
> Smart App Updates Smart app updates is a new feature of Google Play that introduces a better way of delivering app updates to devices. When developers publish an update, Google Play now delivers only the bits that have changed to devices, rather than the entire APK. This makes the updates much lighter-weight in most cases, so they are faster to download, save the device’s battery, and conserve bandwidth usage on users’ mobile data plan. On average, a smart app update is about 1/3 the size of a full APK update.

### 增量更新算法
* rdiff
* bsdiff

> 最早Google也是使用BSDiff作为差分工具，但是对于效果不满意；所以Google对BSDiff进行了优化，并把优化后的算法称为Courgette。优化思路：为代码部分的模块地址分配标签，保存到数组中，指针列表映射的地址改为指向数组的索引。

### BSDiff原理 
1. 对old文件中所有子字符串形成一个字典；
2. 对比old文件和new文件，产生diffstring（最长子序列，可被高效压缩）和extra string；
3. 将diffstring 和extra string 以及相应的控制字用zip压缩成一个patch包。

### 思路
1. 客户端带着VerisionCode发送请求给服务端
2. 服务端判断是否是最新版本,如果不是生成差分包，并反回给客户端Url地址
3. 客户端拿到URL地址下载到SD卡中,并从客户端data/app 目录下拷贝本程序的apk安装包
4. 客户端调用so库封装的方法，合成最新版本的安装包


### 扩展阅读
[BSDiff算法原理](http://blog.csdn.net/add_ada/article/details/51232889)
[Courgette官网](https://www.chromium.org/developers/design-documents/software-updates-courgette)

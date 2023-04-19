# Spark知识点

#### 1. 开启动态推测后。有两个task并跑，如果两个都同时成功了driver怎么做同步处理 ?
根据网络搜索结果，Spark的动态推测机制可以自动重新尝试一个与同一阶段中的其他任务相比没有进展的任务。
这意味着如果一个阶段中有一个或多个任务运行缓慢，它们将被重新启动。首先完成的任务被标记为成功。另一个尝试被杀死。
当两个任务同时成功时，驱动程序会根据任务的完成时间来决定哪个任务是有效的，哪个任务是无效的，并将无效的任务标记为TaskKilled。
驱动程序会同步处理两个任务的结果，并且只使用有效任务的结果。

#### 2. Spark-Sql 原理过程
Spark SQL是一个用于处理结构化数据的Spark模块。它可以使用SQL或DataFrame API来查询存储在Spark内存中的数据，并进行优化。
Spark SQL的核心是一个叫做Catalyst的查询编译器，它将用户程序中的SQL/Dataset/DataFrame经过一系列操作，
最终转化为Spark系统中执行的RDD。Spark SQL的运行流程大致如下：
(1). 用户输入SQL或DataFrame API
(2). Spark SQL解析SQL或DataFrame API，生成未解析的逻辑计划（Unresolved Logical Plan）
(3). Spark SQL进行分析（Analysis），将未解析的逻辑计划转化为已解析的逻辑计划（Resolved Logical Plan），并进行一些优化
(4). Spark SQL进行逻辑优化（Logical Optimization），将已解析的逻辑计划转化为优化后的逻辑计划（Optimized Logical Plan），并进行一些优化
(5). Spark SQL进行物理规划（Physical Planning），将优化后的逻辑计划转化为物理计划（Physical Plan），并选择最佳的物理计划
(6). Spark SQL进行代码生成（Code Generation），将物理计划转化为可执行代码
(7). Spark SQL执行代码，生成结果


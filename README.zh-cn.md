其他语言版本：[English](https://github.com/urovosamples/ScanWedgeAPIsSample/blob/master/README.md)
## 引言

**ScanWedge配置文件**

ScanWedge功能基于配置文件，其中包含有关ScanWedge应如何与一个或多个相关应用程序一起工作的信息，并提供了一种方法，允许可能获取相同数据的不同应用程序以不同方式操作数据。
通过配置文件，ScanWedge可以配置为根据任意数量的单个应用程序的要求处理同一组捕获的数据。或者，可以创建单个配置文件并将其与许多应用程序关联，以完全相同的方式获取和处理数据。单个配置文件可以与一个或多个活动或应用程序相关联，但活动或应用只能与单个配置文件相关联。

**配置文件信息包括：**

* 关联的应用程序
* 扫描读取配置
* 输出方式配置
* 数据处理配置
* 解码器配置

ScanWedge包含默认配置文件Default，该配置文件在ScanWedge首次运行时自动创建。

使用配置文件，每个应用程序都可以具有特定的ScanWedge配置。例如，每个用户应用程序都可以有一个Profile，当该应用程序到达前台时，该Profile以所需格式输出扫描数据。ScanWedge可以被配置为根据每个应用程序的要求不同地处理相同的一组捕获数据。

注意：单个配置文件可以与一个或多个活动或应用程序关联。但是，一个活动只能与多个配置文件关联。

每个配置文件都包含一些选项，也称为功能类别，用于确定数据是如何获取（输入）、处理数据格式（如果需要）和传递到应用程序（输出）的。此外，可选的特定于配置文件的配置设置分类在实用程序下，可以与应用程序关联或在运行时进行控制。

可以创建任意数量的配置文件以满足企业的所有需求。ScanWedge包括多个预先配置的配置文件，以支持一般需求或每个设备内置的特定应用程序。其中一些对用户可见，可以根据需要进行编辑。其他包含固定参数且不可见或不可配置。默认情况下，提供Default以使尚未与任何Profile关联的前台应用程序生效。这可确保ScanWedge随时准备捕获开箱即用的数据。
   
**ScanWedge Intent APIs分为3种类型：**
**配置APIs：**

* 克隆配置文件-以现有Profile配置文件为基础，创建副本，包括所有Profile设置内容。
* 创建配置文件-以默认配置，创建新的配置文件。
* 删除配置文件-删除指定的Profile配置文件。
* 导入配置文件-导入自定义配置文件，其中可以包含多个配置文件，可以覆盖原有配置参数。
*  重命名配置文件-重命名指定Profile配置文件为新的名称。
*  恢复配置-重置所有用户配置的设置，并将ScanWedge恢复为出厂默认设置。
* 参数设置配置-对指定的Profile设置项进行创建、更新或替换配置。
        
        
**查询APIs：**

* 获取当前配置文件-获取ScanWedge当前使用的配置文件的名称。
* 获取参数设置值-获取指定配置文件中的参数列表设置值，作为一组值对或类型配置包返回。
* 获取ScanWedge状态-返回ScanWedge的状态，启用或禁用。
*  获取配置文件列表-返回ScanWedge配置文件列表。
* 获取扫描头状态-返回当前扫描头的状态。


**运行时APIs：**

* 启用/禁用ScanWedge-启用/禁用设备上的ScanWedge,禁用后无法切换到任何未启用的配置文件，仅使用默认配置文件参数。
* 重置默认配置文件-将Default默认配置文件重置为出厂默认设置状态，这是用于未关联应用程序的内置配置文件。
* 软扫描触发-启动、停止软件扫描触发。
* 切换配置文件-将应用程序关联更改为指定的配置文件。
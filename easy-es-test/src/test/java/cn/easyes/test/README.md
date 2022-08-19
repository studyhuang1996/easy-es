# 测试前避坑必读指南

## 注意事项
1.cn.easyes.test.all包下所有测试用例为本框架核心功能测试用例,任何功能改后,需要保证此目录下所有用例全部通过后方可进行代码提交及合并.

2.运行cn.easyes.test.index包下所有测试用例前,必须先修改配置文件,加入easy-es.global-config.process-index-mode=manual把索引托管模式
调整为手动挡模式,否则会造成索引创建冲突及可能带来死锁问题,若不慎出现死锁,可手动删除索引名称为ee-distribute-lock的索引即可.

3.运行除cn.easyes.test.all包下其它所有测试用例前,需要先调整配置文件application.yml,调整为你的es连接地址,密码等.还需要检查当前开启的是自动
挡模式还是手动挡模式,若为手动挡,在运行前需要要通过手动挡API先创建索引,同时需要检查数据,因为有很多测试用例是依赖数据的,没有数据自然是查不到的或者
索引类型不正确也是查不到的,所以不要碰到问题就来抱怨测试用例跑不通,除了all包下的其它测试用例都深度依赖数据和索引结构,比如eq方法的测试,需要对应字段
的索引类型为keyword(或keyword+text类型,查询时字段名称指定为字段名.keyword),诸如这类情况导致的测试用例不能正常跑,实属正常,如果测试用例没跑通
用户可自行检查一下,然后去调整索引和数据,除了all包目录下的测试用例,其它测试用例更多地是给用户写代码提供一些参考,避免小白不会使用.更多避坑指南请参考
官网 https://www.easy-es.cn/
# WebService笔记

![FirstImage](./images/FirstImage.png)

## 一、基本概念

### 1、什么是Web服务

列举一些常见的Web服务：

1. 手机淘宝、京东……

2. 天气预报
2. 手机号归属地
2. 股票查询
2. 发送手机短信
2. 手机充值功能
2. 中英文翻译
2. 银行转账业务
2. 公司的“进销存系统”在某商品缺货时自动给供应商下单



**WebService** 即Web服务，它是一种<span style="color:red;">跨编程语言</span>和<span style="color:red;">跨操作系统平台</span>的远程调用技术。

![WebService工作原理](./images/WebService工作原理.png)



Java 中一共有三种 WebService 规范，分别是：

- JAX-WS（JAX-RPC）：**常用**，客户端和服务端的通讯协议使用 **SOAP协议**，传输数据使用 **XML格式**；
- JAXM&SAAJ
- JAX-RS：**常用**，通讯协议使用 **HTTP协议**，传输数据使用 **XML格式** 或 **JSON格式**；



WebService 三要素：SOAP、wsdl、UDDI



### 2、WebService开发规范

**JAX-WS**

Java API for XML-WebService，JDK1.6自带的版本为 `JAX-WS 2.1`，其底层支持为 JAXB。

JAX-WS（JSR 224）规范的API位于 `javax.xml.ws.*` 包，其中大部分都是注解，提供API操作Web服务（通常在客户端使用的较多，由于客户端可以借助SDK生成，因此这个包中的API我们很少直接使用）。



**JAXM&SAAJ**

Java API for XML Message，主要定义了包含发送和接收消息所需的API，相当于Web服务的服务端，其API位于 `javax.messaging.*` 包，它是Java EE的可选包，因此需要单独下载。



SAAJ（SOAP with Attachment API for Java，JSR 67）是与JAXM搭配使用的API，为构建SOAP包和解析SOAP包提供了重要的支持，支持附件传输，它在服务器端、客户端都需要使用。这里还要提到的是 SAAJ 规范，其API位于 `javax.xml.soap.*` 包。



JAXM&SAAJ 与 JAX-WS 都是基于 SOAP 的Web服务，相比之下：

JAXM&SAAJ 暴露了 SOAP 更多的底层细节，编码比较麻烦，

而 JAX-WS 更加抽象，隐藏了更多的细节，更加面向对象，在使用过程中开发者不需要关心 SOAP 的任何细节。

如果开发者想要控制 SOAP 消息的更多细节，可以使用 JAXM&SAAJ。



**JAX-RS**

JAX-RS 是 Java 针对 REST 风格制定的一套Web服务规范，由于推出的相对较晚，该规范并未随JDK1.6一起发行，开发者需要到 JCP 上单独下载 JAX-RS 规范的接口，其API位于 `javax.ws.rs.*` 包。

这里的 JAX-WS 和 JAX-RS 规范我们采用 <span style="color:red;">Apache CXF</span>作为实现。



### 3、SOAP协议

Simple Object Access Protocol，即**简单对象访问协议**，它是用于交换XML编码信息的轻量级协议。

它有三个主要方面：

​	XML-envelope为描述信息内容和如何处理内容定义了框架，

​	将程序对象编码成为XML对象的规则，

​	执行远程过程调用（RPC）的约定。

<span style="color:red;">SOAP 可以运行在任何其他传输协议上。</span>

SOAP是一个基于XML语言和HTTP的协议，SOAP = HTTP + XML数据。

**SOAP的组成如下**：

- Envelope - 必须，以XML的根元素出现
- Headers - 可选
- Body - 必须，在Body部分，包含要执行的服务器端的方法和发送到服务器端的数据



### 4、wsdl说明书

WebService Definition Language，WebService定义语言，是用机器能理解的方式提供一个（基于XML的）正式描述文档的一种语言。

用于描述WebService及其函数、参数和返回值。因为是基于XML的，所以wsdl既是机器可以理解的，又是人类可阅读的。

1.通过wsdl说明书，可以描述WebService服务端对外发布的服务；

2.wsdl说明书是一个基于XML的文件，通过XML语言描述整个服务；

3.<span style="color:red;">在wsdl说明书中，描述了：</span>

- 对外发布的服务名称（类）
- 接口方法名称（方法）
- 接口参数（方法参数）
- 服务返回的数据类型（方法返回值）



### 5、UDDI

Web服务提供商要将自己开发的Web服务公布到因特网上，就需要使用到UDDI了。

UDDI是一个跨产业、跨平台的开放性架构，可以帮助Web服务提供商在互联网上公布Web服务的信息。

UDDI是一种目录服务，开发者可以通过UDDI来注册和搜索Web服务。

简单来说，UDDI是一个关于Web服务信息的目录，并且UDDI通过 **SOAP** 进行通讯，是基于 `.NET` 构建的。

UDDI 即 Universal Description, Discovery and Integration，也就是通用描述，发现和整合。



### 6、应用场景

WebService可以适用于应用程序集成、软件重用、跨防火墙通信的等需求。不同的业务要求不同。

简单来说，如果一个功能需要被多个系统使用，可以利用WebService开发一个服务端接口，以供不同的客户端应用。主要应用在企业内部系统之间的接口调用、面向公网的WebService服务。

![WebService的应用场景案例](./images/WebService的应用场景案例.png)

**优点**：

- <span style="color:blue;">异构平台的互通性</span>

> 理论上，WebService最大的优势是提供了异构平台的无缝衔接技术手段。
>
> 由于不同的用户使用不同的硬件平台、不同的操作平台、不同的操作系统、不同的软件、不同的通信协议，这就产生了互相通信的需求。
>
> WebService使任何两个应用程序，只要能读写XML，那么就能互相通信。

- <span style="color:blue;">更广泛的软件复用（例如移动端淘宝可以复用Web端淘宝的业务逻辑）</span>

> 软件的复用技术通过组合已有模块来搭建应用程序，能大幅度提高软件的生产效率和质量。用户只要获得了wsdl文件，就可以方便地生成客户端代理，并通过代理访问WebService。

- <span style="color:blue;">成本低、可读性强、应用范围广</span>

> WebService可用基于XML的SOAP来表示数据和调用请求。并且通过HTTP协议传输XML格式的数据。

- <span style="color:blue;">迅捷的软件发行方式</span>

> 每个WebService称为一个生产者，不同的生产者可以互相协同合作完成整个应用。
>
> WebService将彻底地改变软件的发行方式。
>
> 软件供应商可以把软件分解成若干个WebService模块构成的系统，直接在Web上发布。

- <span style="color:red;">跨编程语言的数据通信</span>

> 客户端与服务端可能是用不同的语言开发的，但是通过WebService提供服务接口，客户端与服务端之间可以传递对象数据。



**缺点**：

由于 SOAP 是基于 XML 传输，本身使用XML传输会携带一些无关内容从而影响传输效率，

随着SOAP协议的完善，协议增加了许多内容，这就导致了即使用 SOAP 去完成一个简单的数据传输也会因为携带的信息更多而影响传输效率。



WebService作为Web跨平台访问的标准技术，很多公司都限定要求使用WebService，但如果是简单的接口可以直接使用http传输自定义数据格式，开发更快捷。



### 7、面向服务的架构SOA

![面向服务架构SOA](./images/面向服务架构SOA.png)

<span style="color:red;">WebService可以作为SOA的其中一种实现。</span>



## 二、ApacheCXF框架

https://www.bilibili.com/video/BV15t411S7V1?spm_id_from=333.788.player.switch&vd_source=71b23ebd2cd9db8c137e17cdd381c618&p=7
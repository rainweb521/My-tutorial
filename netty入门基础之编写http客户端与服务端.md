Netty4入门基础之编写http客户端与服务端

2.Netty中客户端、服务端的编解码器
作为服务端而言：
主要工作就是接收客户端请求，将客户端的请求内容解码；发送响应给客户端，并将发送内容编码
所以，服务端需要两个编解码器
* HttpRequestDecoder(将请求内容解码)
* HttpResponseEncoder(将响应内容编码)

作为客户端而言：
主要工作就是发送请求给服务端，并将发送内容编码；接收服务端响应，并将接收内容解码；
所以，客户端需要两个编解码器
* HttpResponseDecoder（将响应内容解码）
* HttpRequestEncoder（将请求内容编码）
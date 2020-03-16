//package com.xzl.netty;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//
//public class TCPServer {
//    public static void main(String[] args){
//        starServer();
//    }
//
//    public static void starServer(){
//        //配置服务端的NIO线程池
//        EventLoopGroup bossGroup=new NioEventLoopGroup();
//        EventLoopGroup workerGroup=new NioEventLoopGroup();
//        try {
//            //创建ServerBootstrap实例
//            ServerBootstrap serverBootstrap=new ServerBootstrap();
//            //初始化ServerBootstrap的线程组
//            serverBootstrap.group(bossGroup,workerGroup);//
//            //设置将要被实例化的ServerChannel类
//            serverBootstrap.channel(NioServerSocketChannel.class);//
//            //在ServerChannelInitializer中初始化ChannelPipeline责任链，并添加到serverBootstrap中
//            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
//                @Override
//                protected void initChannel(SocketChannel socketChannel){
//                    socketChannel.pipeline().addLast(new ServerHandler());
//                }
//            });
//            //标识当服务器请求处理线程全满时，用于临时存放已完成三次握手的请求的队列的最大长度
//            serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024);
//            // 是否启用心跳保活机机制
//            serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
//            //绑定端口后，开启监听
//            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
//            if(channelFuture.isSuccess()){
//                System.out.println("TCP服务启动 成功---------------");
//                //等待服务端关闭监听端口
//                channelFuture.channel().closeFuture().sync();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }finally {
//            //释放线程池资源
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }
//    }
//}
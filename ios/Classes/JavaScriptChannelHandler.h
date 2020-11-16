//
// Created by develop on 2020/11/15.
//

#import <Flutter/Flutter.h>
#import <WebKit/WebKit.h>


@interface FLTJavaScriptChannel : NSObject <WKScriptMessageHandler>

- (instancetype)initWithMethodChannel:(FlutterMethodChannel*)methodChannel
                javaScriptChannelName:(NSString*)javaScriptChannelName;

@end
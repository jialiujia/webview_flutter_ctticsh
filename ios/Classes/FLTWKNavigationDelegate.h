//
// Created by develop on 2020/11/15.
//

#import <Flutter/Flutter.h>
#import <WebKit/WebKit.h>


@interface FLTWKNavigationDelegate : NSObject <WKNavigationDelegate>

- (instancetype)initWithChannel:(FlutterMethodChannel*)channel;

/**
 * Whether to delegate navigation decisions over the method channel.
 */
@property(nonatomic, assign) BOOL hasDartNavigationDelegate;

@end
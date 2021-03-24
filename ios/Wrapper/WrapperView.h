//
//  WrapperView.h
//  ReverseOsmosisDemo
//
//  Created by adrian.hartanto on 24/03/21.
//

#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@class RCTBridge;

@interface WrapperView : UIView

- (instancetype)initWithBridge:(RCTBridge *)bridge contentView:(UIView *)contentView;
- (UIView *)getContentView;

@end

NS_ASSUME_NONNULL_END

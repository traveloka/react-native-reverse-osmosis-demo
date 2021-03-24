//
//  WrapperView.m
//  ReverseOsmosisDemo
//
//  Created by adrian.hartanto on 24/03/21.
//

#import <React/RCTBridge.h>
#import <React/RCTUIManager.h>
#import "WrapperView.h"

@implementation WrapperView {
  RCTBridge *_bridge;
  UIView *_contentView;
}

- (instancetype)initWithBridge:(RCTBridge *)bridge contentView:(UIView *)contentView {
  if (self = [super init]) {
    _bridge = bridge;
    _contentView = contentView;

    UIView *contentViewWrapper = [UIView new];
    [contentViewWrapper addSubview:contentView];

    contentView.translatesAutoresizingMaskIntoConstraints = NO;
    [contentView.leadingAnchor constraintEqualToAnchor:contentViewWrapper.leadingAnchor].active = YES;
    [contentView.trailingAnchor constraintEqualToAnchor:contentViewWrapper.trailingAnchor].active = YES;
    [contentView.topAnchor constraintEqualToAnchor:contentViewWrapper.topAnchor].active = YES;
    [contentView.bottomAnchor constraintEqualToAnchor:contentViewWrapper.bottomAnchor].active = YES;

    [self addSubview:contentViewWrapper];

    contentViewWrapper.translatesAutoresizingMaskIntoConstraints = NO;
    [contentViewWrapper.widthAnchor constraintEqualToAnchor:self.widthAnchor].active = YES;
  }
  return self;
}

- (void)layoutSubviews {
  [super layoutSubviews];

  UIView *subview = self.subviews.lastObject;
  [_bridge.uiManager setSize:subview.bounds.size forView:self];
}

- (UIView *)getContentView {
  return _contentView;
}

@end

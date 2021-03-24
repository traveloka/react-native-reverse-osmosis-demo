//
//  DemoWidgetViewManager.m
//  ReverseOsmosisDemo
//
//  Created by adrian.hartanto on 05/01/21.
//

#import "DemoWidgetViewManager.h"
#import "DemoWidgetViewController.h"
#import "WrapperView.h"

@interface DemoWidgetViewManager ()
@property (strong, nonatomic) NSMutableArray<UIViewController *> *widgets;
@end

@implementation DemoWidgetViewManager

RCT_EXPORT_MODULE(DemoWidget)

@synthesize bridge = _bridge;

- (NSMutableArray *)widgets {
  if (!_widgets) {
    _widgets = [NSMutableArray new];
  }
  return _widgets;
}

- (UIView *)view {
  DemoWidgetViewController *widgetVC = [DemoWidgetViewController new];
  [self.widgets addObject:widgetVC]; // retain VC

  return [[WrapperView alloc] initWithBridge:_bridge contentView:widgetVC.view];
}

- (dispatch_queue_t)methodQueue {
  return dispatch_get_main_queue();
}

+ (BOOL)requiresMainQueueSetup {
  return NO;
}

@end

//
//  DemoWidgetViewManager.m
//  ReverseOsmosisDemo
//
//  Created by adrian.hartanto on 05/01/21.
//

#import <React/RCTUIManager.h>
#import "DemoWidgetViewManager.h"
#import "DemoWidgetViewController.h"

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
  [widgetVC addObserver:self forKeyPath:@"view.bounds" options:NSKeyValueObservingOptionNew context:nil];
  [self.widgets addObject:widgetVC]; // retain VC to use KVO
  return widgetVC.view;
}

- (dispatch_queue_t)methodQueue {
  return dispatch_get_main_queue();
}

+ (BOOL)requiresMainQueueSetup {
  return NO;
}

- (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey,id> *)change context:(void *)context {
  if ([keyPath isEqualToString:@"view.bounds"]) {
    UIViewController *widget = (UIViewController *)object;
    CGRect newRect = [change[@"new"] CGRectValue];
    [_bridge.uiManager setSize:newRect.size forView:widget.view];
  }
}

@end

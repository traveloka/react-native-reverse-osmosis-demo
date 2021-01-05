//
//  DemoWidgetViewController.m
//  ReverseOsmosisDemo
//
//  Created by adrian.hartanto on 05/01/21.
//

#import "DemoWidgetViewController.h"

@interface DemoWidgetViewController ()
@property (weak, nonatomic) IBOutlet UIStackView *stackView;
@property (weak, nonatomic) IBOutlet UIButton *btnToggle;
@property (weak, nonatomic) IBOutlet UILabel *lblHelloWorld;

@end

@implementation DemoWidgetViewController

- (void)viewDidLoad {
  [super viewDidLoad];
  
  self.view.translatesAutoresizingMaskIntoConstraints = NO;
  [self.view.widthAnchor constraintEqualToConstant:UIScreen.mainScreen.bounds.size.width].active = YES;

  self.stackView.translatesAutoresizingMaskIntoConstraints = NO;
  [self.stackView.leftAnchor constraintEqualToAnchor:self.view.leftAnchor].active = YES;
  [self.stackView.topAnchor constraintEqualToAnchor:self.view.topAnchor].active = YES;
  [self.stackView.rightAnchor constraintEqualToAnchor:self.view.rightAnchor].active = YES;
  [self.stackView.bottomAnchor constraintEqualToAnchor:self.view.bottomAnchor].active = YES;
}

- (IBAction)onTogglePress:(id)sender {
  self.lblHelloWorld.hidden = !self.lblHelloWorld.isHidden;
}

@end

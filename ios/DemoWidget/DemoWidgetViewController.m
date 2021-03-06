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
@property (weak, nonatomic) IBOutlet UILabel *lblToggled;

@end

@implementation DemoWidgetViewController

- (void)viewDidLoad {
  [super viewDidLoad];
  
  self.view.translatesAutoresizingMaskIntoConstraints = NO;
  [self.view.widthAnchor constraintEqualToAnchor:self.view.superview.widthAnchor].active = YES;

  self.stackView.translatesAutoresizingMaskIntoConstraints = NO;
  [self.stackView.leftAnchor constraintEqualToAnchor:self.view.leftAnchor].active = YES;
  [self.stackView.topAnchor constraintEqualToAnchor:self.view.topAnchor].active = YES;
  [self.stackView.rightAnchor constraintEqualToAnchor:self.view.rightAnchor].active = YES;
  [self.stackView.bottomAnchor constraintEqualToAnchor:self.view.bottomAnchor].active = YES;
}

- (IBAction)onTogglePress:(id)sender {
  self.lblToggled.hidden = !self.lblToggled.isHidden;
}

- (void)setButtonLabel:(NSString *)label {
  [_btnToggle setTitle:label forState:UIControlStateNormal];
}

- (void)setLabelTitle:(NSString *)title {
  [_lblToggled setText:title];
}

@end

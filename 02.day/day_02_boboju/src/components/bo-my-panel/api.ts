/// <reference types="@nasl/types" />
namespace extensions.day_02_boboju.viewComponents {
  const { Component, Prop, ViewComponent, Slot, Method, Param, Event, ViewComponentOptions } = nasl.ui;

  @ExtensionComponent({
    type: 'pc',
    ideusage: {
      idetype: 'container',
    }
  })
  @Component({
    title: '我的面板',
    description: '我的面板',
  })
  export class BoMyPanel extends ViewComponent {
    constructor(options?: Partial<BoMyPanelOptions>) {
      super();
    }
  }

  export class BoMyPanelOptions extends ViewComponentOptions {
    @Slot({
      title: '标题',
      description: '标题'
    })
    slotHeader: () => Array<nasl.ui.ViewComponent>;

    @Slot({
      title: '内容',
      description: '内容'
    })
    slotDefault: () => Array<nasl.ui.ViewComponent>;

    @Prop({
      title: '是否可以关闭',
      description: '是否显示关闭按钮',
      setter: {
        concept: 'SwitchSetter'
      }
    })
    canClose: nasl.core.Boolean = true;

    @Prop({
      title: '是否可见',
      description: '是否可见',
      setter: {
        concept: 'SwitchSetter'
      }
    })
    visible: nasl.core.Boolean = true;

    @Event({
      title: '关闭',
      description: '关闭'
    })
    closed: (event: { visible: nasl.core.Boolean }) => void;
  }
}

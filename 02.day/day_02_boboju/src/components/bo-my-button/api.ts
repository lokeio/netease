/// <reference types="@nasl/types" />
namespace extensions.day_02_boboju.viewComponents {
  const { Component, Prop, ViewComponent, Slot, Method, Param, Event, ViewComponentOptions } = nasl.ui;

  @ExtensionComponent({
    type: 'both',
    ideusage: {
      idetype: 'element',
    }
  })
  @Component({
    title: '我的按钮',
    description: '我的按钮',
  })
  export class BoMyButton extends ViewComponent {
    constructor(options?: Partial<BoMyButtonOptions>) {
      super();
    }
  }

  export class BoMyButtonOptions extends ViewComponentOptions {
    @Prop({
      title: '标签',
      description: '按钮显示的文本',
      setter: {
        concept: 'InputSetter'
      }
    })
    label: nasl.core.String = '按钮';

    @Prop({
      title: '类型',
      description: '按钮的类型',
      setter: {
        concept: 'EnumSelectSetter',
        options: [{ title: '主要' }, { title: '成功' }, { title: '警告' }, { title: '危险' }, { title: '信息' }]
      }
    })
    type: 'primary' | 'success' | 'warning' | 'danger' | 'info' | 'default' = 'default';

    @Event({
      title: '点击事件',
      description: '按钮被点击时触发',
    })
    onMyClick: (event: {
      timestamp: nasl.core.String,
    }) => void;
  }
}

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
    title: '第二天题目一组件',
    description: '第二天题目一组件',
  })
  export class BoMyButton extends ViewComponent {
    constructor(options?: Partial<BoMyButtonOptions>) {
      super();
    }
  }

  export class BoMyButtonOptions extends ViewComponentOptions {
    @Prop({
      title: '内容',
      description: '显示文本',
      setter: {
        concept: 'InputSetter'
      }
    })
    text: nasl.core.String = '';

    @Prop({
      title: '类型',
      description: '类型',
      setter: {
        concept: 'EnumSelectSetter',
        options: [{ title: '主要' }, { title: '次要' }, { title: '默认' }]
      }
    })
    type: 'primary' | 'secondary' | 'default' = 'default';
  }
}

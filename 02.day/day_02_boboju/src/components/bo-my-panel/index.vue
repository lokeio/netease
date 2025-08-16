<template>
  <div v-show="isShow" :class="$style.root">
    <div :class="$style.header">
      <div :class="$style.headerSlot">
        <slot name="header">标题文本</slot>
      </div>
      <Button v-if="canClose" :class="$style.closeBtn" type="danger" plain @click="handleClose">×</Button>
    </div>
    <div :class="$style.content">
      <slot>内容文本...</slot>
    </div>
  </div>
</template>
<script>
import { Button } from 'element-ui';
export default {
  name: 'my-panel',
  components: {
    Button
  },
  props: {
    canClose: {
      type: Boolean,
      default: true
    },
    visible: {
      type: Boolean,
      default: true
    }
  },
  data() {
    return {
      isShow: this.visible
    }
  },
  watch: {
    visible: {
      handler(newVal) {
        this.isShow = newVal;
      }
    }
  },
  methods: {
    handleClose() {
      this.isShow = false;
      this.$emit('closed', { visible: false });
    }
  }
};
</script>
<style>
@import "element-ui/lib/theme-chalk/button.css";
</style>
<style module>
.root {
  display: flex;
  flex-direction: column;
  border: 1px solid #0006;
  border-radius: 6px;
}
.header {
  border-bottom: 1px solid #0006;
  display: flex;
}
.headerSlot {
  flex: 1;
  padding: 12px;
}
.closeBtn {
  border: none;
  border-radius: 0 5px 0 0;
  padding: 0 16px;
}
.content {
  padding: 12px;
}
</style>

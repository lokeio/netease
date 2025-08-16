<template>
  <Button :type="type" @click="handleClick">{{ label }}</Button>
</template>
<script>
import { Button } from 'element-ui';
export default {
  name: 'bo-my-button',
  components: {
    Button
  },
  props: {
    label: {
      type: String,
      default: '按钮'
    },
    type: {
      type: String,
      default: 'default'
    }
  },
  methods: {
    handleClick(e) {
      this.$emit('my-click', {
        timestamp: (new Date().getTime()).toString(),
      });
    }
  }
};
</script>
<style>
@import "element-ui/lib/theme-chalk/button.css";
</style>

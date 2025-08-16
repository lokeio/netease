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
      const timestamp = new Date().getTime();
      console.log('Button clicked, timestamp:', timestamp);
      this.$emit('my-click', {
        timestamp,
      });
    }
  }
};
</script>
<style>
@import "element-ui/lib/theme-chalk/button.css";
</style>

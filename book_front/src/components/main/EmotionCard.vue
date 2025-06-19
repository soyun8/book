<template>
  <div class="modal-wrap">
    <div class="modal-container">
      <v-card class="mx-auto" max-width="400">
        <v-card-text>
          <div class="font-weight-bold ms-1 mb-2 ">{{ props.word }}</div>
          <v-timeline align="start" density="compact">
            <v-timeline-item
                v-for="message in messages"
                :key="message.key"
                :dot-color="message.color"
                size="x-small"
            >
              <div class="mb-4">
                <div class="font-weight-normal">
                  <strong>{{ message.question }}</strong>
                </div>
                <v-textarea clearable variant="underlined"></v-textarea>
              </div>
            </v-timeline-item>
          </v-timeline>
        </v-card-text>
      </v-card>
    </div>
  </div>
</template>

<script setup>
import {defineProps, ref, watchEffect} from 'vue';

const messages = ref([]);

// 단어 받기
const props = defineProps({
  word: String
});

watchEffect(() => {
  messages.value = [
    {
      key:1,
      question: `무슨 상황에서 그 ${props.word}을(를) 느꼈어?`,
      color: 'purple',
    },
    {
      key:2,
      question: `무슨 상황에서 그 ${props.word}을(를) 느꼈어?`,
      color: 'green',
    },
    {
      key:3,
      question: `무슨 상황에서 그 ${props.word}을(를) 느꼈어?`,
      color: 'deep-purple-lighten-1',
    },
]

})
</script>

<style lang="scss" scoped>
.modal-wrap {
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.4);
}

/* modal or popup */
.modal-container {
  position: relative;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 550px;
  background: #fff;
  border-radius: 10px;
  padding: 20px;
  box-sizing: border-box;
}
</style>
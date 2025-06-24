<template>
  <div class="modal-wrap">
    <div class="modal-container">
      <v-btn
          class="close-btn"
          density="comfortable"
          icon="$close"
          size="x-large"
          variant="plain"
          @click="$emit('close')"
      ></v-btn>
      <v-card class="mx-auto" max-width="400">
        <v-card-text>
          <div class="font-weight-bold ms-1 mb-2" style="font-size: 30px; color:#263238" >{{ props.word }}</div>
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
                <v-textarea
                    clearable
                    variant="outlined"
                    rows="2"
                ></v-textarea>
              </div>
            </v-timeline-item>
          </v-timeline>
          <v-card-actions>
            <v-btn
                class="text-none mb-4"
                text="저장하기"
                color="deep-purple-lighten-2"
                variant="elevated"
                block
                border
                @click="reserve"
            ></v-btn>
          </v-card-actions>
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
      color: 'indigo-darken-1',
    },
    {
      key:2,
      question: `왜 '${props.word}' 이란 단어가 너의 마음 속에서 걸렸어?`,
      color: 'indigo-darken-2',
    },
    {
      key:3,
      question: `그랬구나, 그러면 너는 그 부분을 어떻게 고치고 싶어?`,
      color: 'indigo-darken-3',
    },
    {
      key:4,
      question: `그렇게 고치려면 너는 어떻게 해야할까? (상대에게 어떻게 말해야 너의 생각을 받아들일까?)`,
      color: 'indigo-darken-4',
    },
    {
      key:5,
      question: `만약 해결할 수 없는 문제라면 난 그냥..`,
      color: 'red',
    },
]

})
</script>
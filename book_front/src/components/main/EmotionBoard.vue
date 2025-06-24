<template>
  <h1 class="my-5 p-50 text-center">감정 구름</h1>
  <vue-word-cloud
      :style="{ height: height +'px', width: width + 'px' }"
      :words="words"
      :color="([, weight]) => randomColor()"
  >
    <template v-slot="{ text : text, weight : weight }">
      <div
          style="cursor: pointer;"
          :title="weight"
          @click="open(text)"
      >
        {{ text }}
      </div>
    </template>
  </vue-word-cloud>
</template>

<script setup>
import VueWordCloud from 'vuewordcloud';
import axios from "axios";
import { ref, onMounted } from 'vue';

const emit = defineEmits(['selectWord']);

const open = (word) => {
  emit('selectWord', word);
};

// 1. 조회수와 감정이름 가져오기 15개 나열
const randomColor = () => {
  return "#" + Math.round(Math.random() * 0xffffff).toString(16)
}

const width = ref(900);
const height = ref(480);

const updateSize = () => {
  width.value = window.innerWidth * 0.9;
  height.value = window.innerHeight * 0.6;
};


const words = ref([]);

const getWords = async () => {
  const response = await axios.get('http://localhost:8080/emotions');
  const data = response.data;

  // 배열을 랜덤하게 섞는 함수 (Fisher-Yates 알고리즘)
  const shuffled = data.sort(() => Math.random() - 0.5);

  // 랜덤 20개 선택 후 words에 할당
  words.value = shuffled.slice(0, 20).map(book => [book.emotion, book.hit]);
};

onMounted(() => {
  updateSize();  // 마운트 시 초기 크기 설정
  window.addEventListener('resize', updateSize);
  getWords();    // 워드클라우드 데이터 불러오기
});

</script>
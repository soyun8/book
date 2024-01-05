<template>
  <v-container>
    <v-row align="center" justify="center">
      <v-col
          v-for="(emotion, i) in emotions"
          :key="i"
          cols="auto"
      >
        <v-btn elevation="4" size="x-large" color="#006064" @click="emotionClick(emotion)">{{ emotion }}</v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>
<script setup>

// 1. 감정은 DB에 밀어 넣는다.
// 2. DB에서 가장 조회수가 많은 감정 10가지만 골라온다.
// 3. 더보기를 누르면 감정 선택 페이지로 넘어간다

let emotions = ['감격스럽다', '억울하다', '유쾌하다', '화사한','처량한', '허전한', '서글픈', '열받는','심술나는', '분한', '넌더리나는', '부담스러운']

const emotionClick = (emotion) => {
  console.log(emotion)
}
</script>

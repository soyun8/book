<template>
  <h1 class="my-5 p-50 text-center">감정 구름</h1>
  <vue-word-cloud
      style="height: 480px;width: 1135px;"
      :words="getWordCloudData()"
      :color="([, weight]) => randomColor()"
  >
    <template v-slot="{ text : text, weight : weight }">
      <div
          style="cursor: pointer;"
          :title="weight"
          @click="wordClick(text)"
      >
        {{ text }}
      </div>
    </template>
  </vue-word-cloud>
</template>

<script setup>
import VueWordCloud from 'vuewordcloud';

// 1. 조회수와 감정이름 가져오기 15개 나열
// 2. color 분류는 알아서..하하..
const randomColor = () => {
  return "#" + Math.round(Math.random() * 0xffffff).toString(16)
}

const getWordCloudData = () => {
  return books.map(book => {
    return [book.word, book.weight];
  });
}

const wordClick = (name) => {
  console.log(name)
}

let books = [
    {
      word: 'Frozen Yogurt',
      weight: 15
    },
    {
      word: 'Ice cream sandwich',
      weight: 23
    },
    {
      word: 'Eclair',
      weight: 26
    },
    {
      word: 'Cupcake',
      weight: 30
    },
    {
      word: 'Gingerbread',
      weight: 35
    },
    {
      word: 'Jelly bean',
      weight: 37
    },
    {
      word: 'Lollipop',
      weight: 39
    },
    {
      word: 'Honeycomb',
      weight: 40
    },
    {
      word: 'Donut',
      weight: 45
    },
    {
      word: 'KitKat',
      weight: 51
    },
]


</script>

<style lang="scss" scoped>

</style>
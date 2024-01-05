<template>
  <v-main>
    <v-container>
      <EmotionBoard></EmotionBoard>
      <MainSearch></MainSearch>
      <PopularBooks></PopularBooks>
    </v-container>
  </v-main>
</template>

<script setup>
import MainSearch from "@/components/main/MainSearch.vue";
import EmotionBoard from "@/components/main/EmotionBoard.vue";
import PopularBooks from "@/components/main/PopularBooks.vue";

</script>

<style lang="scss" scoped>

</style>
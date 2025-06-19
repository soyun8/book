<template>
  <v-main>
    <v-container>
      <EmotionBoard />
      <MainSearch />
      <RouterView />
    </v-container>
  </v-main>
</template>

<script setup>
import MainSearch from "@/components/main/MainSearch.vue";
import EmotionBoard from "@/components/main/EmotionBoard.vue";

</script>

<style lang="scss" scoped>

</style>
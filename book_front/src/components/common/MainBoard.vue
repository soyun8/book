<template>
  <v-main>
    <v-container fluid>
      <EmotionBoard @select-word="selectWord" />
      <MainSearch />
      <RouterView />
      <EmotionCard v-model:word="word" v-if="isModalShow" @close="isModalShow = false" />
      <LoginForm v-show="isLoginForm"/>
    </v-container>
  </v-main>
</template>

<script setup>
import MainSearch from "@/components/main/MainSearch.vue";
import EmotionBoard from "@/components/main/EmotionBoard.vue";
import EmotionCard from "@/components/main/EmotionCard.vue";
import {ref} from "vue";
import LoginForm from "@/components/member/LoginForm.vue";

const isModalShow = ref(false);
const word = ref('');
const isLoginForm = ref(false);


const selectWord = (w) => {
  isModalShow.value = true;
  word.value = w;
};
</script>

<style lang="scss" scoped>
@import "../../assets/common/css/class.css";
</style>
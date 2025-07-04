<template>
  <v-main>
    <v-container fluid>
      <EmotionBoard @select-word="selectWord" />
      <MainSearch />
      <RouterView />
      <EmotionCard
        v-model:word="word"
        v-if="isModalShow"
        @close="isModalShow = false"
      />
      <LoginForm v-show="member.isLogin" @close="member.isLogin = false" />
    </v-container>
  </v-main>
</template>

<script setup>
import MainSearch from "@/components/main/MainSearch.vue";
import EmotionBoard from "@/components/main/EmotionBoard.vue";
import EmotionCard from "@/components/main/EmotionCard.vue";
import LoginForm from "@/components/member/LoginForm.vue";
import { ref } from "vue";
import { memberStore } from "@/stores/member";

const member = memberStore();
const isModalShow = ref(false);
const word = ref("");

const selectWord = (w) => {
  isModalShow.value = true;
  word.value = w;
};
</script>

<style lang="scss" scoped>
@import "../../assets/common/css/class.css";
</style>

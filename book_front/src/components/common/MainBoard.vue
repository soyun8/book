<template>
  <v-main>
    <v-container fluid>
      <EmotionBoard @select-word="selectWord" />
      <MainSearch />
      <EmotionCard
        v-model:word="word"
        v-if="isModalShow"
        @close="isModalShow = false"
      />
      <LoginForm v-show="member.isLogin" @close="member.isLogin = false" @signUpForm="signUpForm" />
      <SignUpForm v-show="isSign" />
    </v-container>
  </v-main>
</template>

<script setup>
import MainSearch from "@/components/main/MainSearch.vue";
import EmotionBoard from "@/components/main/EmotionBoard.vue";
import EmotionCard from "@/components/main/EmotionCard.vue";
import LoginForm from "@/components/member/LoginForm.vue";
import SignUpForm from "@/components/member/SignUpForm.vue";
import { ref } from "vue";
import { memberStore } from "@/stores/member";

const member = memberStore();
const isModalShow = ref(false);
const word = ref("");
const isSign = ref(false);

const selectWord = (w) => {
  isModalShow.value = true;
  word.value = w;
};

const signUpForm = async () => {
  isSign.value = true;
  member.isLogin = false;
};
</script>

<style lang="scss" scoped>
@import "../../assets/common/css/class.css";
</style>

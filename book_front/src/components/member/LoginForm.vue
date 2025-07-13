<template>
  <div class="loginForm">
    <v-btn
      class="close-btn"
      density="comfortable"
      icon="$close"
      size="x-large"
      variant="plain"
      @click="$emit('close')"
    ></v-btn>
    <v-card :elevation="1" class="mx-auto px-6 py-8">
      <v-form>
        <v-text-field
          v-model="loginData.email"
          class="mb-2"
          clearable
          label="Email"
        ></v-text-field>

        <v-text-field
          v-model="loginData.pwd"
          clearable
          label="Password"
          placeholder="Enter your password"
        ></v-text-field>

        <br />

        <v-btn
          block
          color="success"
          size="large"
          type="submit"
          variant="elevated"
          @click.once.prevent="$emit('signUpForm')"
        >
          회원가입
        </v-btn>

        <br />

        <v-btn
          block
          color="primary"
          size="large"
          type="submit"
          variant="elevated"
          @click="member.login(loginData)"
        >
          로그인하기
        </v-btn>
      </v-form>
    </v-card>
  </div>
</template>

<script setup>
import { memberStore } from "@/stores/member";
import { ref } from "vue";

const member = memberStore();

const loginData = ref({
  email: "",
  pwd: "",
});


</script>

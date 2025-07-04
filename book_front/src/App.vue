<template>
  <v-app>
    <v-card class="mx-auto">
      <v-layout>
        <NavBar @login="member.loginBtn()"/>
        <router-view />
      </v-layout>
    </v-card>
  </v-app>
</template>

<script setup>
import NavBar from "@/components/common/NavBar.vue";
import { memberStore } from "@/stores/member"

const member = memberStore()
</script>

<style lang="scss" scoped>

</style>


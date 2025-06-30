<template>
  <v-app>
    <v-card class="mx-auto">
      <v-layout>
        <NavBar />
        <router-view />
      </v-layout>
    </v-card>
  </v-app>
</template>

<script setup>
import NavBar from "@/components/common/NavBar.vue";

</script>

<style lang="scss" scoped>

</style>


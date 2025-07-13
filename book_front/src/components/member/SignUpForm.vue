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
            class="mb-2"
            clearable
            label="Email"
        ></v-text-field>

        <v-text-field
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
        >
          회원가입11111
        </v-btn>

        <br />

        <v-btn
            block
            color="primary"
            size="large"
            type="submit"
            variant="elevated"
        >
          로그인하기
        </v-btn>
      </v-form>
    </v-card>
  </div>
</template>

<script setup>

</script>

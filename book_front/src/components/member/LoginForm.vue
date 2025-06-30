<template>
  <v-sheet class="pa-12" rounded>
    <v-card class="mx-auto px-6 py-8" max-width="60%" :elevation="12">
      <v-form
      >
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

        <br>

        <v-btn
            block
            color="success"
            size="large"
            type="submit"
            variant="elevated"
        >
          Sign In
        </v-btn>

        <br>

        <v-btn
            block
            color="primary"
            size="large"
            type="submit"
            variant="elevated"
        >
          Sign Up
        </v-btn>
      </v-form>
    </v-card>
  </v-sheet>
</template>

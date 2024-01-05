<template>
  <h1 class="display-1 my-5 p-50">오늘의 감정 책</h1>
  <v-table>
    <thead style="background-color: rgba(166,175,187,0.64)">
    <tr>
      <th class="text-left">
        제목
      </th>
      <th class="text-left">
        감정
      </th>
      <th class="text-left">
        조회수
      </th>
    </tr>
    </thead>
    <tbody>
    <tr
        v-for="item in books"
        :key="item.name"
    >
      <td>{{ item.name }}</td>
      <td>{{ item.name }}</td>
      <td>{{ item.calories }}</td>
    </tr>
    </tbody>
  </v-table>
</template>

<script setup>
let books = [
  {
    name: 'Frozen Yogurt',
    calories: 159,
  },
  {
    name: 'Ice cream sandwich',
    calories: 237,
  },
  {
    name: 'Eclair',
    calories: 262,
  },
  {
    name: 'Cupcake',
    calories: 305,
  },
  {
    name: 'Gingerbread',
    calories: 356,
  },
  {
    name: 'Jelly bean',
    calories: 375,
  },
  {
    name: 'Lollipop',
    calories: 392,
  },
  {
    name: 'Honeycomb',
    calories: 408,
  },
  {
    name: 'Donut',
    calories: 452,
  },
  {
    name: 'KitKat',
    calories: 518,
  },
]
</script>

<style lang="scss" scoped>

</style>
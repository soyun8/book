<template>
  <div class="modal-wrap">
    <div class="modal-container" v-show="isWrite">
      <v-btn
        class="close-btn"
        density="comfortable"
        icon="$close"
        size="x-large"
        variant="plain"
        @click="$emit('close')"
      ></v-btn>
      <v-card class="mx-auto" max-width="400">
        <v-card-text style="max-height: 70vh; overflow-y: auto">
          <div
            class="font-weight-bold ms-1 mb-2"
            style="font-size: 30px; color: #263238"
          >
            {{ props.word }}
          </div>
          <v-timeline align="start" density="compact">
            <v-timeline-item
              v-for="message in messages"
              :key="message.key"
              :dot-color="message.color"
              size="x-small"
            >
              <div class="mb-4">
                <div class="font-weight-normal">
                  <strong>{{ message.question }}</strong>
                </div>
                <v-textarea
                  clearable
                  rows="2"
                  variant="outlined"
                  v-model="message.data"
                ></v-textarea>
              </div>
            </v-timeline-item>
          </v-timeline>
          <v-card-actions>
            <v-btn
              block
              border
              class="text-none mb-4"
              color="deep-purple-lighten-2"
              text="작성완료"
              variant="elevated"
              @click="cardRead"
            ></v-btn>
          </v-card-actions>
        </v-card-text>
      </v-card>
    </div>

    <!-- 카드 스크린샷 모드 -->
    <div class="modal-container" v-show="isWrite === false">
      <v-btn
        class="close-btn"
        density="comfortable"
        icon="$close"
        size="x-large"
        variant="plain"
        @click="$emit('close')"
      ></v-btn>
      <v-card class="mx-auto" max-width="400" style="overflow: hidden;">
        <v-card-text id="emotionCard" style="max-height: 70vh; overflow-y: auto">
          <div
            class="font-weight-bold ms-1 mb-2"
            style="font-size: 30px; color: #263238"
          >
            {{ props.word }}
          </div>
          <v-timeline align="start" density="compact">
            <v-timeline-item
              v-for="message in messages"
              :key="message.key"
              :dot-color="message.color"
              size="x-small"
            >
              <div class="mb-4">
                <div class="font-weight-normal">
                  <strong>{{ message.question }}</strong>
                </div>
                <div>{{ message.data }}</div>
              </div>
            </v-timeline-item>
          </v-timeline>
        </v-card-text>
      </v-card>
      <v-card-actions v-show="isPublic">
          <v-text-field
            label="닉네임"
            variant="solo"
            v-model="nickName"
          ></v-text-field>&nbsp;&nbsp;&nbsp;&nbsp;
        <v-btn variant="tonal" color="pink" @click="cardPublic">
          익명으로 공유하기
        </v-btn>
      </v-card-actions>
      <v-card-actions v-show="isPublic === false">
        <v-alert text="카드를 공유해주셔서 감사합니다!" variant="outlined" type="success"></v-alert>
      </v-card-actions>
      <v-card-actions>
        <v-btn
          block
          border
          size="x-large"
          class="text-none mb-2"
          color="deep-orange-lighten-2"
          text="저장하기"
          variant="elevated"
          @click="cardSave"
          :disabled="isSaveReadOnly"
        ></v-btn>
      </v-card-actions>
      <v-card-actions>
        <v-btn
          block
          border
          class="text-none mb-4"
          size="x-large"
          color="deep-purple-lighten-2"
          text="캡쳐하기"
          variant="elevated"
          @click="cardCapture"
        ></v-btn>
      </v-card-actions>
    </div>
  </div>
</template>

<script setup>
import { defineProps, ref, watchEffect } from "vue";
import { apiMethods } from "@/utils/api";
import html2canvas from 'html2canvas';

const messages = ref([]);
const isWrite = ref(true); // 글쓰기 모드
const nickName = ref("");
// 체크하면 카드 공개 true, 아니면 false
const privateCard = ref(false);
const isSaveReadOnly = ref(false);
const isPublic = ref(true);

// 단어 받기
const props = defineProps({
  word: String,
});

watchEffect(() => {
  messages.value = [
    {
      key: 1,
      question: `무슨 상황에서 그 ${props.word}을(를) 느꼈어?`,
      color: "indigo-darken-1",
      data: "",
    },
    {
      key: 2,
      question: `왜 '${props.word}' 이란 단어가 너의 마음 속에서 걸렸어?`,
      color: "indigo-darken-2",
      data: "",
    },
    {
      key: 3,
      question: `그랬구나, 그러면 너는 그 부분을 어떻게 고치고 싶어?`,
      color: "indigo-darken-3",
      data: "",
    },
    {
      key: 4,
      question: `그렇게 고치려면 너는 어떻게 해야할까? (상대에게 어떻게 말해야 너의 생각을 받아들일까?)`,
      color: "indigo-darken-4",
      data: "",
    },
    {
      key: 5,
      question: `만약 해결할 수 없는 문제라면 난 그냥..`,
      color: "red",
      data: "",
    },
  ];
});

// 카드 읽어주기 모드
const cardRead = () => {
  isWrite.value = false;
};

// 카드 캡쳐하기
const cardCapture = () => {
  let captureClass = document.getElementById('emotionCard');
  // html2canvas 라이브러리 사용
  html2canvas(captureClass).then(function(canvas) {
    captureClass.style.height = captureClass.scrollHeight + 'px'
    const imageUrl = canvas.toDataURL('image/png');
    const downLink = document.createElement('a');
    downLink.setAttribute('target', '_blank')
    downLink.download = 'fileName' + '.png';
    downLink.href = imageUrl;
    downLink.click();
  });
};

// 카드 공유하기 (웹에 게시하기)
const cardPublic = async () => {
  privateCard.value = true;
  // TODO. 랜덤 닉네임 한번 해보기
  // 아이디 없이 저장하는 부분
  await saveApi().then(() => {
    isPublic.value = false; // 공유가 감사하다는 문구 show
   })
};

// 카드 저장하기
const cardSave = async () => {
  privateCard.value = false;
  // TODO. 로그인을 하면 저장하기 누른 뒤에 내 카드에 저장하겠냐 묻가,
  // 비 로그인시 닉네임 이용해 공개 여부만 체크
  await saveApi().then(() => {
    // 저장하기 버튼 disable
    isSaveReadOnly.value = true
  })
};

const saveApi = async () => {
  const answer = {
    word: props.word,
    answers: messages.value.map((msg) => msg.data),
    privateCard: privateCard.value,
    nickName: nickName.value,
  };
  await apiMethods.cardSave(answer)
}
</script>

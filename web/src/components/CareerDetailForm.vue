<template>
  <div class="careerDetailForm">
    <h1>職務経歴詳細入力フォーム</h1>
    <div class="form">
      <form action="" method="post">
        <div>
          <label class="label-title">プロジェクト名</label>
          <input type="text" v-model="title" />
        </div>
        <div>
          <label class="label-title">社外プロジェクト</label>
          <input type="checkbox" v-model="externalFlg" />
        </div>
        <div>
          <label class="label-title">期間</label>
          <input type="date" v-model="fromDate" />
          <label> ～ </label>
          <input type="date" v-model="toDate" />
        </div>
        <div>
          <label class="label-title">プロジェクト内容</label>
          <textarea v-model="content" />
        </div>
        <input type="submit" value="登録" />
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'CareerDetailForm',
  props: {
  },
  data() {
    return {
      title: '',
      externalFlg: false,
      fromDate: '',
      toDate: '',
      content: ''
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

  .form {
    text-arign: left;
  }
  
  .label-title {
    font-size: 1.3em;
    color: #33cc33;
  }
  
</style>

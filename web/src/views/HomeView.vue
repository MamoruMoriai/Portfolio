<template>

  <div class="home">
  
    <div class="login">
      <button class="loginBtn">ログイン</button>
    </div>
  
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App!!"/>
    
    <div class="careerSummary">
      <label class="articleTitle">職務経歴概要</label>
      <article class="articleContent">
        専修大学ネットワーク情報学部卒業後、株式会社エルパに入社し、
        システムエンジニアとして3年半従事しました。
        入社後は業務システム開発を主業として、Ｗｅｂアプリケーションやストアドプロシージャ、
        バッチプログラムやシミュレーションモデルの開発をしました。
      </article>
    </div>
    
    <div class="careerKeyword">
      <label class="articleTitle">活かせる経験・知識・技術</label>
      <ul class="">
        <li></li>
        <li></li>
        <li></li>
      </ul>
    </div>
    
    <div class="qualifications">
      <label class="articleTitle">保有資格</label>
      <ul class="">
        <li></li>
        <li></li>
      </ul>
    </div>
    
    <div class="publicRelations">
      <label class="articleTitle">自己PR</label>
      
    </div>
    
  </div>
  
</template>

<style>

  .careerSummary {
    margin: auto;
    text-align: left;
    width: 40%;
  }
  
  .articleTitle {
    font-size: 1.5em;
    font-weight: bold;
  }
  
  .articleContent {
    
  }
  
</style>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  }
}
</script>

<template>

  <div class="home">
  
    <div class="login">
      <button class="loginBtn">ログイン</button>
    </div>
  
    <img alt="Vue logo" src="../assets/logo.png">
    <CareerDetail msg="Welcome to CareerDetail!!"/>
    <HelloWorld msg="Welcome to Your Vue.js App!!"/>
    
    <div class="careerSummary">
      <label class="articleTitle">職務経歴概要</label>
      <article class="articleContent">
        専修大学ネットワーク情報学部卒業後、株式会社エルパに入社し、
        システムエンジニアとして3年半従事しました。
        入社後は業務システム開発を主業として、Ｗｅｂアプリケーションやストアドプロシージャ、
        バッチプログラムやシミュレーションモデルの開発をしました。
        
        専修大学ネットワーク情報学部 ： ネットワーク情報学部｜専修大学 (senshu-u.ac.jp)
        株式会社エルパ ：  ホーム | 株式会社エルパ（www.lpa.co.jp）
        GitHub ： MamoruMoriai (mamoru_moriai) (github.com)
        Qiita ： mamoru_moriai - Qiita
        
      </article>
    </div>
    
    <div class="careerKeyword">
      <label class="articleTitle">活かせる経験・知識・技術</label>
      <ul class="">
        <li>オブジェクト指向を意識したプログラミング経験（デザインパターン等）</li>
        <li>C#/Java等の静的型付き言語による開発経験（計３年）</li>
        <li>社内制度の導入経験</li>
      </ul>
    </div>
    
    <div class="qualifications">
      <label class="articleTitle">業務経験のある技術 / 環境</label>
      <ul class="">
        <li></li>
        <li></li>
      </ul>
    </div>
    
    <div class="qualifications">
      <label class="articleTitle">業務外経験のある技術 / 環境</label>
      <ul class="">
        <li></li>
        <li></li>
      </ul>
    </div>
    
    <div class="qualifications">
      <label class="articleTitle">保有資格</label>
      <ul class="">
        <li>基本情報技術者試験（平成30年度春期合格）</li>
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

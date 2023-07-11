<template>

  <div class="home">
  
    <div class="login">
      <button class="btn btn-primary">ログイン</button>
    </div>
      
    <div class="careerSummary article">
      <div class="articleTitle">職務経歴概要</div>
      <article class="articleContent">
        専修大学ネットワーク情報学部卒業後、株式会社エルパに入社し、システムエンジニアとして3年半従事しました。入社後は業務システム開発を主業として、Ｗｅｂアプリケーションやストアドプロシージャ、バッチプログラムやシミュレーションモデルの開発をしました。
        
      
        
      </article>
      <ul class="articleContent">
        <li><a href="https://www.senshu-u.ac.jp/education/faculty/network/">専修大学ネットワーク情報学部</a></li>
        <li><a href="http://www.lpa.co.jp/">株式会社エルパ</a></li>
        <li><a href="https://github.com/MamoruMoriai">GitHub</a></li>
        <li><a href="https://qiita.com/mamoru_moriai">Qiita</a></li>
      </ul>
    </div>
    
    <CareerDetail />
    
    <div class="careerKeyword article">
      <div class="articleTitle">活かせる経験・知識・技術</div>
      <ul class="articleContent">
        <li>オブジェクト指向を意識したプログラミング経験（デザインパターン等）</li>
        <li>C#/Java等の静的型付き言語による開発経験（計３年）</li>
        <li>社内制度の導入経験</li>
      </ul>
    </div>
    
    <div class="qualifications article">
      <div class="articleTitle">業務経験のある技術 / 環境</div>
      <ul class="articleContent">
        <li></li>
        <li></li>
      </ul>
    </div>
    
    <div class="qualifications article">
      <div class="articleTitle">業務外経験のある技術 / 環境</div>
      <ul class="articleContent">
        <li></li>
        <li></li>
      </ul>
    </div>
    
    <div class="qualifications article">
      <div class="articleTitle">保有資格</div>
      <ul class="articleContent">
        <li>基本情報技術者試験（平成30年度春期合格）</li>
      </ul>
    </div>
    
    <div class="publicRelations article">
      <div class="articleTitle">自己PR</div>
      
    </div>
    
  </div>
  
</template>

<style>

  .home {
    text-align: left;
  }

  .article {
    margin: 60px 0;
  }
  
  .articleTitle {
    margin: 5px auto;
    text-align: left;
    width: 45%;
    font-size: 1.2em;
    font-weight: bold;
  }
  
  .articleContent {
    margin: 5px auto;
    text-align: left;
    width: 45%;
    font-size: 1em;
  }
  
</style>

<script>
// @ is an alias to /src
import CareerDetail from '@/components/CareerDetail.vue'

export default {
  name: 'HomeView',
  components: {
    CareerDetail
  }
}
</script>

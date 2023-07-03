import './Result.css';
import {useNavigate,useLocation} from 'react-router-dom';


function Result(){
    const navigate = useNavigate();
    const location = useLocation();
    const userMbti = location.state.value;

    return (
     <div class="Result">
        <div className="upperTitle">
            <h2>MBTI</h2>
        </div>

        <div className="userMbti">
            <p>{userMbti}</p>
            <p className="result">는</p>
        </div>

        {/*서버에서 mbti 정보 가져올 부분*/}
        <div className="detailMbti">

        </div>

        <div className="btns">
            <button onClick={()=>{navigate('/');}}>홈</button>
            <button onClick={()=>{navigate('/admin');}}>관리자 페이지</button>
        </div>

        <div className="lowerTitle"></div>

     </div>
    );
}
export default Result;
import logo from '../assets/logo.png'

const Logo = () => {
  return (
    <a className='navbar-brand' href='#'>
      <img 
        src={logo}
        alt='logo'
        width={48}
        height={48}
        />
    </a>
  )
}

export default Logo